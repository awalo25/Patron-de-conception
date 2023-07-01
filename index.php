<!DOCTYPE html>
<html>

<head>
	<title>LOGIN</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<form action="login.php" method="post">
		<h2>LOGIN</h2>
		<?php if (isset($_GET['error'])) { ?>
			<p class="error"><?php echo $_GET['error']; ?></p>
		<?php } ?>
		<label></label>
		<input type="text" placeholder="User_name"><br>

		<label></label>
		<input type="text" placeholder="Password"><br>

		<button type="submit">Login</button>
	</form>
</body>

</html>