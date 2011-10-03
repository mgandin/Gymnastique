function Calculator() {
}
Calculator.prototype.product=function(input,index){
	var result = new Array();
	for(var j = 0; j < index.length; j++) {
		var product = 1;
		for(var i = 0; i < input.length; i++) {
			if(i!=index[j])
				product *= input[i];
		}
		result.push(product);
	}
	return result;
}
