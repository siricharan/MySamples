

def main():
    f = open('first.py', 'r')
    data = f.read()
    print(data)
    f.close()

if __name__ == '__main__':
    main()