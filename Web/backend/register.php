<?php
    session_start();
    $conn = mysqli_connect('localhost','tinnt','123','Web');
    if($conn->connect_errno){
        echo "Failed to connect: ".$conn->connect_error;
        exit();
    }
?>