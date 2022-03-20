nome = "ailton santos"

##d = {}
##for i in nome:
##    if i in d: 
##        d[i] += 1
##    else:
##        d[i] = 1

#print(d.items())

from collections import defaultdict

d = defaultdict(int)

for i in nome:
    d[i] += 1
