def func_variadica(*lista, **dicionario):
    print
    "lista: ", lista
    print
    "dicionario:", dicionario


def func_com_return(name):
    return name


def procedimento():
    x = 5
    y = 1
    print
    x + y
    print
    """segunda funcao
               segunda linha
               terceira linha
               quarta linha"""


def retorna_um_monte():
    return 1, 2, 3, 4, 5


if __name__ == '__main__':
    lista = [1, 2, 3, 4, 5]
    dic = {'a': 1, 'b': 2, 'c': 3}
    func_variadica(lista, **dic)
