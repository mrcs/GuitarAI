<?PHP
	$acordes = file('dicionario');
	for ($i = 0; $i < count ($acordes); $i++) {
		$exploded = explode(" ", $acordes[$i]);

		$maj = 0;	// maj
		$sus = 0;	// sustenido
		$bem = 0;	// bemol
		$men = 0;	// menor
		$set = 0;	// setima
		
		/*
		 * 0: não é sustenido, bemol, maj
		 * 1: não é bemol nem maj
		 * 2: todos
		 */
		$nome = $exploded[0];
		$diagrama = trim($exploded[1]);
		
		if (strpos($exploded[0], "#") != 0) 
			$sus = true;
		else if (strpos($exploded[0], "b") != 0) 
			$bem = true;

		if (strpos($exploded[0], "7") != 0)
			$set = true;

		if (strpos($exploded[0], "maj") != 0)
			$maj = true;
		else if (strpos($exploded[0], "m") != 0)	
			$men = true;
			
		if (!($maj || $sus || $bem))
			$nivel = 0;
		else if (!($maj || $bem))
			$nivel = 1;
		else 
			$nivel = 2;

		echo "INSERT INTO `acorde` (`nome`, `sustenido`, `bemol`, `setima`, `menor`, `maj`, `diagrama`, `nivel`) VALUES	('".$nome."','".$sus."','".$bem."','".$set."','".$men."','".$maj."','".$diagrama."','".$nivel."');\n";
		

		
				
		#debug
//		echo $exploded[0]."\t#: ".$sus."\t b: ".$bem."\t 7: ".$set."\t maj: ".$maj."\t m: ".$men."\n"; 
	}

?>
