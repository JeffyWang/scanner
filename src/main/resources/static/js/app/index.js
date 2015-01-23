require.config({
    "baseUrl" : "js",
    "paths" : {
        "app": "app",
        "jquery" : "lib/jquery/jquery",
        "underscore" : "lib/underscore/underscore",
        "backbone" : "lib/backbone/backbone",
        "react" : "lib/react/react"
    },
    "shim" : {
        "backbone" : {
            "deps" : [
                "jquery",
                "underscore"
            ],
            "exports" : "Backbone"
        },
        "jquery" : {
            "exports" : "$"
        },
        "underscore" : {
            "exports" : "_"
        }
    }
});

requirejs(["module/index"]);