grammar MatrixLang;

prog
	: tk_main '{' body '}'
	;

body
	: (variable | proceso)*
	;

variable
	: tk_int variable_list ';'		# DeclareInt
	| tk_matrix variable_list ';'	# DeclareMat
	;

variable_list
	: ID (',' ID)*
	;

proceso
	: tK_ID '=' tk_NUM ';'				# DefineInt
	| tK_ID '=' matrix ';'				# DefineMat
	| tK_ID '=' operacion ';'			# DefineOp
	| 'write' tK_ID ';'					# WriteOnConsole
	;

operacion
	: '(' operacion ')'					# Parenthesis
	| operacion '^'						# Transpose
	| operacion tk_mult operacion			# Multiplication
	| operacion tk_add operacion			# Addition
	| operacion tk_sub operacion			# Substraction
	| matrix							# MatrixOp
	| tK_ID								# VariableOp
	;

matrix
	: '[' column (';' column)* ']'
	;

column
	: NUM (',' NUM)*
	;


// Tokens

tk_main: 'main';
tk_int: 'int';
tk_matrix: 'matriz';
tK_ID: ID;
tk_NUM: NUM;
tk_add: '+';
tk_sub: '-';
tk_mult: '*';

// Lexer Rules

ID	: 	[a-zA-Z][a-zA-Z0-9_]* ;	// identifiers	# ID
NUM	:	[0-9]+ ;			// numbers
WS	:	[ \t\r\n]+ -> skip ;  	// skip spaces, tabs, newlines