def func_range():
    start = 5
    stop = 10
    step = 1
    type(range(start, stop, step))
    list(range(start, stop, step))


def func_continue():
    print()
    print("inicio")
    i = 0
    while (i < 10):
        i += 1
        if (i % 2 == 0):
            continue
        if (i > 5):
            break
        print(i)
    else:
        print("else")
    print("fim")


def func_while():
    x = 0
    while (x <= 10):
        print(x)
    x += 1


def veirifica_par():
    num = int(input("Digite um numero: "))

    if (num % 2 == 0):
        print("{0} é par".format(num))
    else:
        print("{0} nao é par".format(num))


def for_loop():
    for a in range(10):
        print (a)

if __name__ == '__main__':
    #func_continue()
    #func_range()
    # func_while()
    for_loop()