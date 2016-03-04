<?php
	header('Content-type: application/json');
	$status = array(
		'type'=>'success',
		'message'=>'Thank you for contact us. As early as possible  we will contact you '
	);

    $name = @trim(stripslashes($_POST['name'])); 
    $mail = @trim(stripslashes($_POST['mail'])); 
    $website = @trim(stripslashes($_POST['website'])); 
    $comment = @trim(stripslashes($_POST['comment'])); 

    $email_from = $mail;
    $email_to = 'ialamin.pro@gmail.com;//replace with your email

    $body = 'Name: ' . $name . "\n\n" . 'Email: ' . $mail . "\n\n" . 'Subject: ' . $website . "\n\n" . 'Message: ' . $comment;

    $success = @mail($email_to, $subject, $body, 'From: <'.$email_from.'>');

    echo json_encode($status);
    die;