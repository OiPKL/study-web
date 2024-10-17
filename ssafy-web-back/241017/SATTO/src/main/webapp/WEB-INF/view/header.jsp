<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SATTO</title>
<style>
	#main {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		height: 90vh;
		gap: 16px;
		font-weight: 1000;
	}
	@keyframes fontBlink {
		0% { color: purple; }
		100% { color: red; }
	}	
	#satto {
		text-decoration: none;
		font-size: 80px;
		font-weight: 1000;
	}
	.blink {
		animation-name: fontBlink;
		animation-duration: 0.2s;
		animation-iteration-count: infinite;
		animation-timing-function: steps(2, end);
	}
	#submit > input, #submit > a {
		text-decoration: none;
		border: none;
		background-color: inherit;
		color: inherit;
		font: inherit;
		cursor: pointer;
	}
	
	input[type="number"]::-webkit-outer-spin-button,
	input[type="number"]::-webkit-inner-spin-button {
	    -webkit-appearance: none;
	    margin: 0;
	}
	#line {
		display: flex;
		flex-direction: row;
		gap: 8px;
	}
	#form {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		gap: 16px;
	}
	.num {
		font-size: 24px;
		width: 30px;
		text-align: center;
	}
	input.num {
		border: 2px solid black;
		border-radius: 4px;
	}
	
	#type {
		display: flex;
		flex-direction: column;
	}
	#submit {
		display: flex;
		justify-content: center;
		align-items: center;
		width: 140px;
		height: 40px;
		font-size: 20px;
		font-weight: 800;
		color: black;
		background-color: white;
		border: 2px solid black;
		border-radius: 12px;
		cursor: pointer;
	}
	hr {
		width: 350px;
		border: 1px dashed black;
	}
	#result {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		gap: 4px;
		font-size: 24px;
	}
	#error {
		color: red;
	}
</style>
<body>
<div id="main">
<a href="/" id="satto" class="blink">SATTO</a>
