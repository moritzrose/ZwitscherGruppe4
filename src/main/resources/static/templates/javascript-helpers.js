nunjucks.configure()
    // Allows for acccessing a passed in JSON list via 'list()'
    .addGlobal('list',
        function () {
            return Object.values(this.getVariables())
                         .map(item => ({ ...item }));
        })
    // Save current template data (raw JSON) in a variable 'key' so that other templates can access it
    // Example {{save('user')}}
    .addGlobal('save',
        function (key) {
            window[key] = this.getVariables();
            // return window.user;
    })
    // Load previously saved template data via 'key'
    // Example {{load('user').username}}
    .addGlobal('load',
        function (key) {
            return window[key];
        })
    // Allows for acccessing a query parameter passed via an URL
    .addGlobal('query',
        function (key) {
            return new URLSearchParams(window.location.search).get(key);
    })
    // Triggers a redirect to a different page, the second parameter is optional and allows for a delay in milleseconds
    .addGlobal('redirect',
        function (pageUrl,timeInMs= 0) {
            return makeJsLazilyExecutable(this,`setTimeout(() => window.location.href="${pageUrl}", ${timeInMs})`);
    });

function makeJsLazilyExecutable(context,javascriptString){
    // Returned html is not escaped (alternativly you need to use | safe filter)
    context.env.opts.autoescape = false;
    return "<script>" + javascriptString + "</script>";
}