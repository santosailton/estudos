class Programa:
    def __init__(self, nome, ano):
        self._nome = nome.title()
        self.ano = ano
        self._likes = 0

    @property  # propriedade para retornar atributos da classe
    def likes(self):
        return self._likes

    def dar_likes(self):
        self._likes += 1

    @property
    def nome(self):
        return self._nome

    @nome.setter  # propriedade para alterar atributos da classe
    def nome(self, nome):
        self._nome = nome

    def __str__(self):  # metodo pythonico para retorno de strings em uma classe
        return f'Nome: {self.nome} Likes: {self.likes}'


class Filme(Programa):  # herdando caracteristicas da classe pai
    def __init__(self, nome, ano, duracao):  # reutilizando atributos da classe pai
        super().__init__(nome, ano)
        self.duracao = duracao

    def __str__(self):  # polimorfismo de metodos __str__ para ser usado o metodo de cada classe
        return f'Nome: {self.nome} - {self.duracao} min - Likes: {self.likes}'


class Serie(Programa):
    def __init__(self, nome, ano, temporadas):
        super().__init__(nome, ano)
        self.temporadas = temporadas

    def __str__(self):  # polimorfismo de metodos __str__ para ser usado o metodo de cada classe
        return f'Nome: {self.nome} - {self.temporadas} temporadas - Likes: {self.likes}'


class Playlist():
    def __init__(self, nome, programas):
        self.nome = nome
        self._programas = programas

    def __getitem__(self, item):  # data model, metodos para interagir com objetos
        return self._programas[item]

    def __len__(self):  # data model, metodos para interagir com objetos
        return len(self._programas)


vingadores = Filme('vingadores - guerra infinita', 2018, 160)
atlanta = Serie('atlanta', 2018, 2)
tmep = Filme('todo mundo em panico', 1999, 100)
demolidor = Serie('demolidor', 2016, 2)

vingadores.dar_likes()
vingadores.dar_likes()
vingadores.dar_likes()
atlanta.dar_likes()
atlanta.dar_likes()
tmep.dar_likes()
tmep.dar_likes()
demolidor.dar_likes()
demolidor.dar_likes()

listinha = [atlanta, vingadores, demolidor, tmep]
minha_playlist = Playlist('fim de semana', listinha)

for programa in minha_playlist:
    print(programa)

print(f'Tamanho: {len(minha_playlist)}')
