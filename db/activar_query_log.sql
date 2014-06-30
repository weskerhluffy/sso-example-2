-- XXX: http://stackoverflow.com/questions/303994/log-all-queries-in-mysql
SET global log_output = 'FILE';
SET global general_log_file='/tmp/caca.log';
SET global general_log = 1;
