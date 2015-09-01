create or replace package ref_cursor is

  type cursorType is ref cursor;
  
  function klanten_ophalen return cursorType;
  
end;
/

create or replace package body ref_cursor is

  function klanten_ophalen return cursorType is
  
    rc cursorType;
  
  begin

    open rc for select naam from j_klanten;
    return rc;

  end;

end;
/
