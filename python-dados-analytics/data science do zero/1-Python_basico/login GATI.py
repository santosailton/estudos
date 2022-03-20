import subprocess
import keyboard
login = 'login'
passwd = 'senha'

subprocess.call(["C:\Program Files (x86)\Google\Chrome\Application\chrome.exe",
                 "http://10.100.1.52/ebtdti/gerenciaderequisitos/v3/index.asp"])
keywordkeyboard.write(login)
keywordkeyboard.press_and_release('tab')
keywordkeyboard.write(passwd)
keywordkeyboard.press_and_release('Enter')
