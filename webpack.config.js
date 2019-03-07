const ExtractTextPlugin = require("extract-text-webpack-plugin");
const FileManagerPlugin = require('filemanager-webpack-plugin');
const { VueLoaderPlugin } = require('vue-loader');

module.exports = {
    entry: './src/main/js/app.js',
    output: {
        filename: 'js/bundle.js',
        path: __dirname + '/build/resources/main/static/'
    },
    module: {
        rules: [
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            },
            {
                test: /\.js$/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/env']
                    }
                },
                exclude: /node_modules/
            },
            {
                test: /\.css$/,
                use: ExtractTextPlugin.extract({
                    fallback: "style-loader",
                    use: "css-loader"
                })
            },
        ]
    },
    plugins: [
        new VueLoaderPlugin(),
        new ExtractTextPlugin("css/styles.css"),
        new FileManagerPlugin({
            onEnd: {
                copy: [
                    {
                        source: __dirname + '/build/resources/main/static/js/bundle.js',
                        destination: __dirname + '/src/main/resources/static/js/bundle.js'
                    },
                    {
                        source: __dirname + '/build/resources/main/static/css/styles.css',
                        destination: __dirname + '/src/main/resources/static/css/styles.css'
                    }
                ]
            }
        })
    ]
};
