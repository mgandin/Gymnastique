class Batch
	attr_reader :fileName

	def initialize (fileName)
		@fileName = fileName
	end
	
	def gets
		file = File.new(@fileName)
		result = []
		number = []
		counter = 1
		while (line = file.gets)
			number << line.chomp
			if (counter % 3 == 0)
				result << number
				number = []
			end
			counter = counter + 1
		end
		return result
	end
	
end