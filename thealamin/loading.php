<!DOCTYPE html>
<html lang="en">
    <head>
        <!--
        <title>Al-Amin | An Independent Freelancer</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1">
        <link rel="stylesheet" type="text/css" href="css/style-dark.css">-->
        
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript">
            
            var text = "";
            var count = 0;
            var maxspeed = 200;
            
            $(document).ready(function(){
                
                function type(){
                        var random = Math.floor(Math.random() * maxspeed);
                    set.timeout(type,random);
                    $('#box').append('a');
                
                }
                type();
            } );
        
        </script>
        
    </head>
    <body class="body-load">
        <div id="box"></div>
        
    
    </body>



</html>