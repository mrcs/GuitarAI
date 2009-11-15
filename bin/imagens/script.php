<?PHP
	$acordes = file('dicionario');
	for ($i = 0; $i < count ($acordes); $i++) {
		$exploded = explode(" ", $acordes[$i]);
//		http://www.how-to-play-guitar.eu/guitar_chords/A/Am7_Guitar_Chord.gif
// 		http://www.how-to-play-guitar.eu/guitar_chords/Asharp/Asharp_Guitar_Chord.gif
// Provides: <body text='black'>
		$modificador = "";
		if (strpos($exploded[0], "#") != 0) {
			$modificador = "sharp";
			$exploded[0] = str_replace("#", "sharp", $exploded[0]);
		} else 	if (strpos($exploded[0], "b") != 0) 
			$modificador = "b";
		echo "http://www.how-to-play-guitar.eu/guitar_chords/".$exploded[0][0].$modificador."/".$exploded[0]."_Guitar_Chord.gif\n";
		//echo $exploded[0][0]."\n";
	}
?>
