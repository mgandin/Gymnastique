require 'test/unit'
require 'Bank'
require 'Converter'
require 'Batch'

class TestBank < Test::Unit::TestCase
	attr_reader :ocr
	attr_reader :converter
	attr_reader :batchAccount

	def setup
		@converter = Converter.new()
		@batchAccount = Batch.new("account.txt")
		@ocr = Bank.new(converter,batchAccount)
	end

	def testShouldConvertQuantifyAsciiZero
		assert_equal('0',@converter.convertQuantifyFor([" _ ",
					    					   "| |",
					    					   "|_|"]))
	end
	
	def testShouldConvertQuantifyAsciiOne
		assert_equal('1',@converter.convertQuantifyFor(["   ",
											   "  |",
											   "  |"]))
		assert_equal('?',@converter.convertQuantifyFor([]))
	end
	
	def testShouldConvertNumberAsciiOne
		assert_equal("1",@ocr.convertNumberFor(["   ",
											 "  |",
											 "  |"]))
	end
	
	def testShouldConvertNumberAsciiTwoAndThree
		tab = [" _  _ ",
			   " _| _|",
			   "|_  _|"]
		assert_equal("23",@ocr.convertNumberFor(tab))
	end
		
	def testShouldConvertNumberAscii123
		tab = ["    _  _ ",
 			   "  | _| _|",
 			   "  ||_  _|"]
 		assert_equal("123",@ocr.convertNumberFor(tab))
	end
	
	def testShouldConvertNumberAscii123456789
		tab = ["    _  _     _  _  _  _  _ ",
			   "  | _| _||_||_ |_   ||_||_|",
			   "  ||_  _|  | _||_|  ||_| _|"]
 		assert_equal("123456789",@ocr.convertNumberFor(tab))
	end
	
	def testShouldCalculeChecksum
		assert_equal("",@ocr.verifyChecksumFor("345882865"))
		assert_equal("ERR",@ocr.verifyChecksumFor("664371495"))
		assert_equal("ILL",@ocr.verifyChecksumFor("86110??36"))
	end
	
	def testShouldConvertAndCheckAValidAccount
		tab = [" _     _  _  _  _  _  _  _ ",
			   " _||_||_ |_||_| _||_||_ |_ ",
			   " _|  | _||_||_||_ |_||_| _|"]
		
		output = @ocr.loadAndOutputAccount(tab)
		assert_equal("345882865 ",output)
	end	
	
	def testShouldConvertAndCheckInvalidAccount 
		tab = [" _  _     _  _        _  _ ",
			   "|_ |_ |_| _|  |  ||_||_||_ ",
			   "|_||_|  | _|  |  |  | _| _|"]
		output = @ocr.loadAndOutputAccount(tab)
		assert_equal("664371495 ERR",output)
	end
	
	def testShouldTryToConvertAndCheckIllegalAccount
		tab = [" _  _        _  _     _  _ ",
			   "|_||_   |  || |       _||_ ",
			   "|_||_|  |  ||_|       _||_|"]
			   
		output = @ocr.loadAndOutputAccount(tab)
		assert_equal("86110??36 ILL",output)
	end
	
	def testShouldReadAccountFilesAndGiveOutPut
		expectedAccounts = [
			[" _     _  _  _  _  _  _  _ ",
			   " _||_||_ |_||_| _||_||_ |_ ",
			   " _|  | _||_||_||_ |_||_| _|"],
			[" _  _     _  _        _  _ ",
			   "|_ |_ |_| _|  |  ||_||_||_ ",
			   "|_||_|  | _|  |  |  | _| _|"],
			[" _  _        _  _     _  _ ",
			   "|_||_   |  || |       _||_ ",
			   "|_||_|  |  ||_|       _||_|"]
			]
		assert_equal(expectedAccounts,@batchAccount.gets)
		finalOutput = @ocr.load
		expectedOutput = "345882865se\n664371495 ERR\n86110??36 ILL\n"
		assert_equal(expectedOutput,finalOutput)
	end
end
