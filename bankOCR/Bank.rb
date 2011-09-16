require 'Converter'

class Bank

	attr_reader :converter
	attr_reader :batchAccount

	def initialize (converter,batchAccount)
		@converter = converter
		@batchAccount = batchAccount
	end
	
	def convertNumberFor(codeAscii)
		@converter.convertNumberFor(codeAscii)
	end
	
	def verifyChecksumFor(accountNumber)
		return "ILL" if accountNumber.include? "?"
		return checksum(accountNumber) != 0 ? "ERR" : ""
	end
	
	def checksum(accountNumber)
		(accountNumber.split("")[8].to_i+
		2*accountNumber.split("")[7].to_i+
		3*accountNumber.split("")[6].to_i+
		4*accountNumber.split("")[5].to_i+
		5*accountNumber.split("")[4].to_i+
		6*accountNumber.split("")[3].to_i+
		7*accountNumber.split("")[2].to_i+
		8*accountNumber.split("")[1].to_i+
		9*accountNumber.split("")[0].to_i) %11
	end
	
	def loadAndOutputAccount(codeAscii)
		outputForAccountNumber = convertNumberFor(codeAscii) << " " << verifyChecksumFor(convertNumberFor(codeAscii))
	end
	
	def load
		allAccountAsTab = @batchAccount.gets
		result = ""
		allAccountAsTab.each do | accountNumber |
			result << loadAndOutputAccount(accountNumber) << "\n"
		end
		return result
	end
end