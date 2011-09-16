class Converter
	def quantifyLength
		3
	end
	
	def convertQuantifyFor(codeAscii)
		block = {[" _ ",
				  "| |",
				  "|_|"]=>'0',
				 ["   ",
				  "  |",
				  "  |"]=>'1',
				 [" _ ",
				  " _|",
				  "|_ "]=>'2',
				 [" _ ",
				  " _|",
				  " _|"]=>'3',
				 ["   ",
				  "|_|",
				  "  |"]=>'4',
				 [" _ ",
				  "|_ ",
				  " _|"]=>'5',
				 [" _ ",
				  "|_ ",
				  "|_|"]=>'6',
				 [" _ ",
				  "  |",
				  "  |"]=>'7',
				 [" _ ",
				  "|_|",
				  "|_|"]=>'8',
				 [" _ ",
				  "|_|",
				  " _|"]=>'9'}

		block[codeAscii].nil? ? '?' : block[codeAscii]
	end
	
	def convertNumberFor(codeAscii)
		convertedNumber = ""
		position=0
		while (lastQuantifyIsnotReachFor(position,codeAscii))
			convertedNumber << convertedQuantify(codeAscii,position)
			position+=quantifyLength()
		end
		return convertedNumber
	end
	
	def numberLength(codeAscii)
		codeAscii[0].size
	end
	
	def convertedQuantify(codeAscii,position)
		convertQuantifyFor(codeAscii.map{|line| line[position..position+2]})
	end
	
	def lastQuantifyIsnotReachFor(position,codeAscii)
		position+quantifyLength() <= numberLength(codeAscii)
	end
end