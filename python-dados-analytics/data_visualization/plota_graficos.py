import matplotlib.pyplot as plt


def plota_grafico():
    x = [1, 2, 5]
    y = [2, 3, 7]
    ex = "Eixo X"
    ey = "Eixo Y"
    # titulo
    plt.title("Primeiro grafico")

    # legendas
    plt.xlabel(ex)
    plt.ylabel(ey)

    plt.plot(x, y)
    plt.show()


def plota_grafico_barras():
    x = [1, 2, 3, 4, 5]
    y = [2, 3, 7, 1, 8]
    ex = "Eixo X"
    ey = "Eixo Y"

    # titulo
    plt.title("Segundo grafico")
    # legendas
    plt.xlabel(ex)
    plt.ylabel(ey)
    # grafico
    plt.bar(x, y)
    plt.show()


def compara_grafico():
    x1 = [1, 2, 5]
    y1 = [2, 3, 7]
    x2 = [3, 4, 6]
    y2 = [6, 7, 1]

    # titulo
    plt.title("Terceiro grafico")
    # legendas
    plt.xlabel("Eixo X")
    plt.ylabel("Eixo Y")
    # graficos
    plt.bar(x1, y1)
    plt.bar(x2, y2)
    plt.plot(x1, y1)
    plt.show()


def scatterplot():
    x = [1, 2, 3, 4, 5]
    y = [2, 3, 7, 1, 8]
    # titulo
    plt.title("Quarto grafico")
    # legendas
    plt.xlabel("Eixo X")
    plt.ylabel("Eixo Y")
    plt.plot(x,y, color="k", linestyle="--")
    plt.scatter(x,y, #pontos X e Y
                label="Meus pontos", #rótulo do gráfico
                marker="h", #tipo de ponto
                color="r",  #cor dos pontos
                s=100) #tamanho dos pontos
    plt.legend()
    plt.show()
# A seguir, alguns exemplos de argumentos que podem ser aplicados ao método plot( ).
#
#
#
# color: cor (ver exemplos abaixo)
#
# label: rótulo
#
# linestyle: estilo de linha (ver exemplos abaixo)
#
# linewidth: largura da linha
#
# marker: marcador (ver exemplos abaixo)
#
#
#
# CORES (color)
# 'b' blue
#
# 'g' green
#
# 'r' red
#
# 'c' cyan
#
# 'm' magenta
#
# 'y' yellow
#
# 'k' black
#
# 'w' white
#
#
#
# Marcadores (marker)
# '.' point marker
#
# ',' pixel marker
#
# 'o' circle marker
#
# 'v' triangle_down marker
#
# '^' triangle_up marker
#
# '<' triangle_left marker
#
# '>' triangle_right marker
#
# '1' tri_down marker
#
# '2' tri_up marker
#
# '3' tri_left marker
#
# '4' tri_right marker
#
# 's' square marker
#
# 'p' pentagon marker
#
# '*' star marker
#
# 'h' hexagon1 marker
#
# 'H' hexagon2 marker
#
# '+' plus marker
#
# 'x' x marker
#
# 'D' diamond marker
#
# 'd' thin_diamond marker
#
# '|' vline marker
#
# '_' hline marker
#
#
#
#
#
# Tipos de linha (linestyle)
# '-' solid line style
#
# '--' dashed line style
#
# '-.' dash-dot line style
#
# ':' dotted line style

if __name__ == '__main__':
    # aula 5
    # plota_grafico()
    # aula 6
    # plota_grafico_barras()
    # aula 7
    # compara_grafico()
    # aula 8
    scatterplot()