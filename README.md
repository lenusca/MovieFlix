HOW TO RUN:

To run the application, you need to get all dependecies... Run this command in your linux terminal.
1 - docker-compose -f docker-compose.yml up -d --build

When all is install, in brower put this url
2 - http://localhost:3000/


To see kafka working, you need to add a movie or a serie, and next put this url in your browser to see the message exchange between Consumer and Producer
3 - http://localhost:8888/allMessages 

NOTE : 
There is also a demo/video, movieflix.mp4, which you can see how our application works if you can't run it on your pc