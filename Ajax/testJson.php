<?php
$myArray = array();
$arrTmp = array(1,2,3,4,5);

$myArray[] = $_GET['name'];
$myArray[] = $_GET['age'];
$myArray[] = $arrTmp;

$st = json_encode($myArray);
echo $st;


?>