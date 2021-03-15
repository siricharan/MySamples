from mockito import mock, verify
import unittest
from first import helloworld

class FirstTest(unittest.TestCase):

    # @unittest.skip('skipped test')
    def test_should_issue_hello_world_message(self):
        out = mock()
        helloworld(out)
        verify(out).write("Hello world of Python.\n")