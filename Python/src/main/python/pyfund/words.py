#!C:\U1sers\uidq5530\Anaconda3\envs\rasaenv362\python
""" Retrieve and print words from a URL.

Usage:
    python words.py <URL>
"""
import sys
from urllib.request import urlopen
def fetch_words(url="https://sixty-north.com/c/t.txt"):
    """Fetch a List of words from Url.

    Args:
        url: The URL of a UTF-8 text Document.

    Returns:
        A list of strings containing the words
        from the provided URL
    """
    # with urlopen("https://www.google.com/") as story:
    with urlopen(url) as story:
        story_words = []
        for line in story:
            line_words = line.decode('utf-8').split()
            # line_words = line.split()
            for word in line_words:
                story_words.append(word)
    story.close()
    return story_words

def print_items(items):
    for item in items:
        print(item)



def main(url):
    words = fetch_words(url)
    print_items(words)


if __name__ == '__main__':
    main(sys.argv[1]) # the 0th argument
