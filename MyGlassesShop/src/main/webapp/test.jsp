<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title> Face Detection Tutorial</title>

  <script src="js/data/tracking.js"></script>
  <script src="js/data/face-min.js"></script>
  <script src="js/data/eye-min.js"></script>
  <script src="js/data/mouth-min.js"></script>

  <style>
    .rect {
      border: 2px solid #a64ceb;
      left: -1000px;
      position: absolute;
      top: -1000px;
    }

    #img {
      position: absolute;
      top: 50%;
      left: 50%;
      margin: -173px 0 0 -300px;
    }
  </style>
  <script>
    window.onload = function() {
      var img = document.getElementById('img');

      var tracker = new tracking.ObjectTracker(['eye']); // Based on parameter it will return an array.
      tracker.setStepSize(1.7);

      tracking.track('#img', tracker);

      tracker.on('track', function(event) {
        event.data.forEach(function(rect) {
          draw(rect.x, rect.y, rect.width, rect.height);
          console.log(rect);
        });
      });

      function draw(x, y, w, h) {
        var rect = document.createElement('div');
        document.querySelector('.imgContainer').appendChild(rect);
        rect.classList.add('rect');
        rect.style.width = w + 'px';
        rect.style.height = h + 'px';
        rect.style.left = (img.offsetLeft + x) + 'px';
        rect.style.top = (img.offsetTop + y) + 'px';
      };
    };
  </script>

</head>
<body>
<div class="imgContainer">
  <img id="img" src="img/big_11-04-18.jpg" />
</div>

</body>
</html>
