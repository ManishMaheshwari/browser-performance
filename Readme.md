##Improving Web Performance Metrics


This project allows us to experiment with various web performance metrics, and validate the factors that impact TTFB, First Paint, First Contentful Paint, Largest Contentful Paint, DocumentContentLoaded, OnLoad, Time to Interactive, First Input Delay, etc.

You can experiment with a shell HTML page, by configuring download latencies of various resources (CSS, JS, Images) in their URL.   

Getting started:

1. Check `src/main/resources/static/index.html`
2. Run `ServerApplication.java` from IDE
3. Open <http://localhost:8080/index.html> in the browser, and use ChromeTools to run Lighthouse audit.
4. `View traces` to inspect the various performance metrics 
5. Try different latencies for JS, CSS & Image in index.html, and repeat from 1
6. Try changing the order of resource nodes in index.html, and repeat from 1
7. Try async, defer with script tage in index.html, and repeat from 1
8. Try different parsing/evaluation times in JS script files, and repeat from 1
 
