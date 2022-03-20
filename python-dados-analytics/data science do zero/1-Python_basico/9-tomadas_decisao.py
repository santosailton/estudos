# tomadas de decisao

# operadores logicos
# and (e)
# or (ou)
# not (negação)
# is (é)
# is not (não é)
# in (está contido)
# not in (não está contido)
import os


def func_if():
    op = 0
    clear = os.system('cls')
    while op != 3:
        op = int(input("1-sim\n2-nao\n3-sair\n"))
        if (op == 1):
            print("sim")
        elif (op == 2):
            print("nao")
        else:
            print("nenhum dos dois")


def func_ternario():
    num = int(input("Digite um numero: "))
    res = "é par" if num % 2 == 0 else "não é par"
    print("o numero {0} {1}".format(num, res))
