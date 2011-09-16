function Pong() {
	this.x = 100;
	this.y = 100
}
Pong.prototype.draw = function(context) {
	context.fillRect(this.x,this.y,10,10);
}

Pong.prototype.move = function() {
	this.x += 10;
	this.y += 10;
}
