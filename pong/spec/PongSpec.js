describe("The game of pong", function() {
	context = {fillRect : jasmine.createSpy()};
	var pong;
	beforeEach(function() {
		pong = new Pong();
	});
	it("draw a ball", function() {
		pong.draw(context);
		expect(context.fillRect).toHaveBeenCalledWith(100,100,10,10);
	});

	
	describe("the ball move to the right",function() {
		beforeEach(function() {
			pong.move();
		});

		it("move a ball one time", function() {
			pong.draw(context);
			expect(context.fillRect).toHaveBeenCalledWith(110,110,10,10);
		});


		it("move the ball",function(){
			pong.move();
			pong.draw(context);
			expect(context.fillRect).toHaveBeenCalledWith(120,120,10,10);
		});
	});
});
