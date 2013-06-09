<html>
<body>
<?php

class MyClass{
    public $prop1 = "I'm a class property!";
}

$obj = new MyClass();

var_dump($obj);

echo $obj->prop1;
echo '<p>Hello</p>'
?>
</body>
</html>