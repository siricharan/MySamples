import sys

def helloworld(out):
    out.write("Hello world of Python.\n")


def main():
    helloworld(sys.stdout)

if __name__ == "__main__":
    main()