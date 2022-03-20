def input_float(msg):
    while True:
        try:
            valores = [float(input(msg))]
            for a in range(len(valores)):
                pass
        except ValueError:
            print("Número invalido!")


def erro():
    try:
        eval(x)
    except ValueError as e:
        print("ValueError")
        print(type(e))  # instancia da excecao
        print(e.args)  # argumentos das msgs
        print(e)  # __str__ msg
    except ZeroDivisionError:
        print("divisao por zero")
    except (TypeError, NameError):
        print("TypeError ou NameError")


n1 = input_float("Digite 1º número: ")
n2 = input_float("Digite 2º número: ")
eval("divisao_zero()")
