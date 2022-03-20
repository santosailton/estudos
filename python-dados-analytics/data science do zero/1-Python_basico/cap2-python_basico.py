lista_x = range(10)  # lista
tupla_y = (1, 2, 3, 4)  # tupla, lista imutavel
dict_z = {"a": 5,
          "b": 6,
          "c": 10}
# [ INICIO : FIM ] com sinal negativo, realiza o inverso
print "X:           ", lista_x

print "x[:3]        ", lista_x[:3]
print "x[3:]        ", lista_x[3:]

print "x[-3:]       ", lista_x[-3:]
print "x[:-3]       ", lista_x[:-3]

print "x[1:-1]      ", lista_x[1:-1]

print 1 in [1, 2, 3]
print 0 in [1, 2, 3]

lista_x = [1, 2, 3, 4]
lista_x.extend([12, 13, 14])
print "x:", lista_x
lista_x.append(4)
print "x:", lista_x

print type(tupla_y)


def soma_produto(a, b):
    return (a + b), (a * b)


s, p = soma_produto(3, 3)
print "s:", s
print "p:", p

print "-----------------------DICIONARIOS"
try:
    print dict_z["z"]
except KeyError:
    print "Chave nao encontrada"

print dict_z.get("v")

tweet = {
    "user": "joelgrus",
    "text": "Data Science is Awesome",
    "retweet_count": 100,
    "hashtags": ["#data", "#science", "#datascience", "#awesome", "#yolo"]
}
