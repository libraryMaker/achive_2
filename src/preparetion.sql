create database ACHIVE;
create table ACHIVE.numbers (numbers bigint);
DELIMITER $$
CREATE function ACHIVE.addNumber(
    number_input bigint
)
RETURNS varchar(1000)
BEGIN
if (number_input < 0) THEN
	
		return 'Number less then zero!';
	
	ELSE
	if ( select exists (select 1 from ACHIVE.numbers where numbers = number_input) ) THEN
	
		return 'Number exitsts !!';
	
	ELSE
	
			if ( select exists (select 1 from ACHIVE.numbers where numbers = (number_input + 1)) ) THEN
	
				return 'Number is less by 1 then exitsting !!';
	
			ELSE
		
				insert into ACHIVE.numbers
				(
					numbers
				)
				values
				(
					number_input
				);
                
                return (select number_input + 1);
                
        END IF;
	END IF;
    END IF;
END$$
DELIMITER ;