from bs4 import BeautifulSoup
import requests
from urllib import request
from urllib.request import urlopen
import pyfund.words

import user_credentials
user = user_credentials.user_credentials()
username = user.get_user_name()
password = user.get_user_pwd()

def read_with_urllib():
    story = request.urlopen('http://finance.yahoo.com/q?s=aapl&ql=1')
    for lines in story.readlines():
        print (lines)
    story.closee()

def read_with_urllib1():
    with urlopen("https://www.google.com/") as story:
        story_words = []
        for line in story:
            line_words = line.split()
            for word in line_words:
                story_words.append(word)
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

def main():
    print('from main')
    # read_with_urllib1()
    #read_with_urllib()
    # read_with_bs4()

if __name__ == "__main__":
    main()
