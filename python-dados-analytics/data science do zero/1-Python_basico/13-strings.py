def tabela_ascii():
    for c in range(127):
        str(c) + " - " + chr(c)


def fatiando():
    a = "PYTHON"
    print("1 - ", a[2:5])
    print("2 - ", a[:2])
    print("3 - ", a[:-2])
    print("4 - ", a[2:])
    print("5 - ", a[-2:])


def iterando_string():
    print
    "----ITERANDO STRINGS----"
    a = "PYTHON_LANGUAGE"
    for k, v in enumerate(a):
        print(k, v)


if __name__ == '__main__':
    fatiando()
    tabela_ascii()
    iterando_string()
