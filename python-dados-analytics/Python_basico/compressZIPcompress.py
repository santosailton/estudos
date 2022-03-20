import zipfile
import glob
from tqdm import tqdm


def compacta():
    file = glob.glob("DXC**.txt")
    print("Compactando...")
    for i in tqdm(range(len(file))):
        print ()
        print (file[i])
        zf = zipfile.ZipFile(file[i][:len(file[i]) - 4] + '.zip', mode='w')
        zf.write(file[i], compress_type=zipfile.ZIP_DEFLATED)
        zf.close()


if __name__ == '__main__':
    compacta()
    print("______________________________________")
    print("FIM DA EXECUÇÃO")
    res = input("PRESSIONE UMA TECLA PARA SAIR....")
