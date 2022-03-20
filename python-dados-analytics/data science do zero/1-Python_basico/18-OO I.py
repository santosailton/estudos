class Retangulo:
    def __init__(self):
        print(id(self))
        self.a = 0
        self.l = 0
    def area(self):
        return self.a * self.l

r1 = Retangulo()
r1.a=10
r1.l=5
print("Area do retangulo: ", r1.area())
