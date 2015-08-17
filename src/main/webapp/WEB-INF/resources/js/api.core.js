function HeroCloneApi(apiLocation) {
    this.apiLocation = apiLocation;
    
    this.makeCall = function(method, payload, handler) {
        var methods=["getSamples"];
        var requestMethods=["GET"];
        
        var whichMethod = $.inArray(method, methods); 
        
        if (whichMethod == -1) {
            return false;
        }
        
        
        $.ajax({
           dataType: 'json',
           url: this.apiLocation + method,
           method: requestMethods[whichMethod],
           data: payload,
           success: handler,
           error: handler
        });
    }
}