from bs4 import BeautifulSoup
import requests
from urllib import request
from urllib.request import urlopen
import pyfund.words

import user_credentials
user = user_credentials.user_credentials()
username = user.get_user_name()
password = user.get_user_pwd()
count =0


def read_with_urllib():
    story = request.urlopen('http://finance.yahoo.com/q?s=aapl&ql=1')
    for lines in story.readlines():
        print (lines)
    story.closee()

def read_with_urllib1():
    with urlopen("https://sixty-north.com/c/t.txt") as story:
        story_words = []
        for line in story:
            line_words = line.split()
            for word in line_words:
                story_words.append(word.decode('utf-8'))
    story.close()
    print(story_words)


def read_with_bs4():
    url = "https://confluence.vitesco.io/pages/viewpage.action?pageId=29675121"
    response = requests.get(url, auth=(username, password))
    soup = BeautifulSoup(response.text)
    print('++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++')
    print(soup.body.find('div', attrs={'class': 'plugin_pagetree_children_container'}).text)


    # for lines in soup:
        # print (lines)
    # print('++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++')
    # for link in soup.find_all('a'):
        # print(link.get('href'))

def print_border(message, message2, border='-'):
    line =border * len(message)
    print(line)
    print(message)
    print(line)

def print_count():
    print(count)


def set_count(c):
    global count
    count = c


def main():
    print('from main')
    print_count()
    set_count(5)
    print_count()

    # print_border("Hello", 'hai', "#")
    # print_border(border='*', message2="Hello", message='hai')
    print_border( "Hello", border='*', message2='hai')
    #read_with_urllib1()
    #read_with_urllib()
    # read_with_bs4()

if __name__ == "__main__":
    main()
