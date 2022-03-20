#!/bin/sh
##
# script para gerar patch pro kernel a partir
# das mudancas do desenvolvedor
#
# Autor: Renê de Souza Pinto
#

if [ $# != 2 ]; then
	echo "Use: $0 <orig_dir> <dev_dir>"
	echo
	exit 1
fi

LINUXDIR=$1
DEVDIR=$2
DDIFF=$LINUXDIR/Documentation/dontdiff

TMPFILE=`mktemp`
DEBDIR=`mktemp -d`

DONTDIFF="mkpiggy piggy.S vmlinux.* voffset.h zoffset.h \
capflags.c inat-tables.c r100_reg_safe.h r200_reg_safe.h \
r300_reg_safe.h r420_reg_safe.h r600_reg_safe.h rv515_reg_safe.h \
rs600_reg_safe.h rn50_reg_safe.h mkregtable hash \
*.builtin *.cis *.alias *.symbols *.dep"

if [ -d "$DEVDIR/debian" ]; then
	mv "$DEVDIR/debian" "$DEBDIR/" > /dev/null 2>&1
	RESTOREDEB=1
else
	RESTOREDEB=0
fi

if [ -f "$DDIFF" ]; then
	if [ -f "$TMPFILE" ]; then
		cp $DDIFF $TMPFILE
		for notdiff in $DONTDIFF; do
			echo $notdiff >> $TMPFILE
		done
		DIFFARG="-X $TMPFILE"
	else
		DIFFARG="-X $DDIFF"
	fi
else
	DIFFARG=""
fi

diff -uprN $DIFFARG $LINUXDIR $DEVDIR 

if [ $RESTOREDEB -eq 1 ]; then
	mv "$DEBDIR/debian" "$DEVDIR/" > /dev/null 2>&1
fi

rm $TMPFILE > /dev/null 2>&1
rmdir $DEBDIR > /dev/null 2>&1

