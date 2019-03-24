import SimpleHTTPServer  
import SocketServer  
import re

def htc(m):  
    return chr(int(m.group(1),16))  
  
def urldecode(url):  
    rex=re.compile('%([0-9a-hA-H][0-9a-hA-H])',re.M)  
    return rex.sub(htc,url)  

class SimpleServer(SocketServer.TCPServer):
    def __init__(self):
        super(SimpleServer, self).__init__()
        self.keyword = None
        self.flag = False


class SETHandler(SimpleHTTPServer.SimpleHTTPRequestHandler):

    #def createHTML(self):  
    #    html = file("index.html", "r")  
    #    for line in html:  
    #        self.wfile.write(line)  
              
    #def do_GET(self):  
    #    print "GET"  
    #    print self.headers;  
    #    self.createHTML()  
          
    def check_message(self,message,keywords):
        if keywords in message:
            return 1
        else:
            return 0

    def do_POST(self):  
        #print "POST"  
        #print self.headers;
        length = int(self.headers.getheader('content-length'))  
        qs = self.rfile.read(length)  
        url=urldecode(qs)
        flag=server.flag
        self.server.flag=check_message(url,self.server.keywords)
        if self.server.flag:
            server.server_close()
            test_util.test_pass()



          
Handler = SETHandler  
PORT = 8082  
httpd = SocketServer.TCPServer(("", PORT), Handler)
httpd.serve_forever()


