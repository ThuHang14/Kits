<?php
$mailArray = array('abc@hmail.com','cnd@gmail.com',"c@gmail.com");

$email = $_GET['email'];
    if(in_array($email,$mailArray)) echo 'false';
    else echo 'true';
?>