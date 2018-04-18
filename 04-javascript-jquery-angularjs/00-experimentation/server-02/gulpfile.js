const gulp = require('gulp');
const csso = require('gulp-csso');
const less = require('gulp-less');
const typescript = require('gulp-typescript');
const webpack = require('webpack-stream');

gulp.task('less', () => {
	return gulp.src('src/components/main.less')
		.pipe(less())
		.pipe(csso())
		.pipe(gulp.dest('public/css'));
});

gulp.task('typescript', () => {
	return gulp.src('src/**/*.ts')
		.pipe(typescript(require('./tsconfig.json')))
		.pipe(gulp.dest('bin'));
});

gulp.task('webpack', () => {
	return gulp.src('src/components/client.tsx')
		.pipe(webpack())
		.pipe(gulp.dest('public/js'));
});

gulp.task('default', ['less', 'typescrpt', 'webpack']);
