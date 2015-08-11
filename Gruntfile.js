/*global module:false*/
module.exports = function(grunt) {

  // Project configuration.
  grunt.initConfig({
	clean: ['src/main/webapp/resources/base/js/build/'],
    // Compile JSX files to build/ folder
    react: {
        options:      {
          transform:  [ require('grunt-react').browserify ]
        },
	compile: 
            {
                expand: true, // enable Dynamic expansion
                cwd: 'src/main/webapp/resources/base/js/source',
                src: ['*/*.react.js','*.react.js'],
                dest: 'src/main/webapp/resources/base/js/build/',
                ext: '.react.js'
            }
        },

    uglify: {
        options: {
            compress: true,
            mangle: true
        },
        concat: {
	        files: [
		        { 
		            src: ['src/main/webapp/resources/base/js/build/components/*.react.js'],  // source files mask
		            dest: 'src/main/webapp/resources/base/js/build/components/components.react.min.js'
		        },
		        { 
		            src: ['src/main/webapp/resources/base/js/build/mixin/*.react.js'],  // source files mask
		            dest: 'src/main/webapp/resources/base/js/build/mixin/mixin.react.min.js'
		        }
	        ]
    	},
		only_minify: {
			files: [
				{
					expand: true,
					cwd: 'src/main/webapp/resources/base/js/build/admin',
					src: '*.react.js',
					dest: 'src/main/webapp/resources/base/js/build/admin',
					ext: '.react.min.js',
				},
				{
					expand: true,
					cwd: 'src/main/webapp/resources/base/js/build/menu',
					src: '*.react.js',
					dest: 'src/main/webapp/resources/base/js/build/menu',
					ext: '.react.min.js',
				}
			]
	    }
    },

	cssmin: {
		options: {
			shorthandCompacting: false,
			roundingPrecision: -1
		},
		target: {
			files: {
				'src/main/webapp/resources/base/app.min.css': [
					'src/main/webapp/resources/base/*/*.css',
					'src/main/webapp/resources/base/*.css', 
					'src/main/webapp/resources/base/css/!*.min.css', 
					'src/main/webapp/resources/base/!*.min.css'
					]
			}
		}
	},

    watch: {
        react: {
            files: ['src/main/webapp/resources/base/js/source/*/*.react.js','src/main/webapp/resources/base/js/source/*.react.js'],
            tasks: ['react'],
             options: {
                spawn: false
            }

        }
    }

  });

  grunt.event.on('watch', function(action, filepath) {

  });

  // These plugins provide necessary tasks.
  grunt.loadNpmTasks('grunt-contrib-clean');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-react');
  grunt.loadNpmTasks('grunt-browserify');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-cssmin');
  // Default task.
  grunt.registerTask('default', ['react']);//, 'uglify', 'cssmin', 'clean', 

};

