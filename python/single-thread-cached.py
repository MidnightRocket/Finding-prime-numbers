import time
from colorama import Fore, Back, Style
from colorama import init as colorama_init

colorama_init(autoreset=True)
colors = dict(Fore.__dict__.items())



def isPrime(number, primeArray=[]):
    if (number == 0 or number == 1):
        return False;
    else:
        i = 2
        root = int(number**0.5)+1

        for i in primeArray:
            if (i >= root):
                return True
            elif (number % i == 0):
                return False

        while (i < root):
            if (number % i == 0):
                return False
            i += 1 if i==2 else 2
        return True

def generatePrimeList(number):
    primeList = []

    colorsToUse = ['BLUE', 'CYAN', 'GREEN', 'LIGHTBLACK_EX', 'LIGHTBLUE_EX', 'LIGHTCYAN_EX', 'LIGHTGREEN_EX', 'LIGHTMAGENTA_EX', 'LIGHTRED_EX', 'LIGHTWHITE_EX', 'LIGHTYELLOW_EX', 'MAGENTA', 'RED', 'WHITE', 'YELLOW']
    amountOfColors = len(colorsToUse)
    currentColor = 0
    i = 2
    while (len(primeList) < number):
        if (isPrime(i, primeList)):
            primeList.append(i)

            print(colors[colorsToUse[currentColor]] + str(i) + colors["RESET"], end=",")
            currentColor += 1
            if (currentColor >= amountOfColors):
                currentColor = 0

        i += 1 if i==2 else 2
    print()
    return primeList

while True:
    answer = input(Fore.YELLOW + "Input a number to test: " + Fore.GREEN)
    if (answer == "exit"):
        print("bye!")
        break

    try:
        number = int(answer)
    except:
        print("try again")
    else:
        startTime = time.time()
        generatePrimeList(number)
        print(time.time()-startTime)
