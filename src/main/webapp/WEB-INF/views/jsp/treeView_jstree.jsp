<%-- 
    Document   : treeView
    Created on : Aug 1, 2017, 10:38:25 AM
    Author     : MikeX
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Tree View Page</title>
        
        <link rel="stylesheet" href="resources/core/css/themes_treeView/default/style.min.css" />
        
    </head>
    <body>
        <h1>Tree View</h1>
        
        <!-- 3 setup a container element -->
        <div id="jstree1">
          <!-- in this example the tree is populated from inline HTML -->
          <!--ul>
            <li>Root node 1
              <ul>
                <li id="child_node_1">Child node 1</li>
                <li>Child node 2</li>
              </ul>
            </li>
            <li>Root node 2</li>
          </ul-->
          
        </div>
        
        <button>demo button</button>
        <br>
        <form>
            <br>
            Search <input id="search_tree" type="text" /> 
        </form>
        <br>
        
        <div id="jstree"></div>
        
        <script src="resources/core/js/jquery.min.js" > </script>
        <script src="resources/core/js/jstree.min.js" > </script>

        <script>
            $(function() { 
                
                $("#jstree").jstree({"core" : {
                    'data' : [
                        { "id" : "ajson1", "parent" : "#", "text" : "root1" },
                        { "id" : "ajson2", "parent" : "#", "text" : "root2" },
                        { "id" : "child_node_1", "parent" : "ajson1", "text" : "child 1" },
                        { "id" : "child_node_2", "parent" : "ajson1", "text" : "child 2" }
                        ]
                    } ,         
                    
                    //"multiple" : "false",
                    
                    "plugins" : ["changed", "checkbox", "contextmenu", "search"]
                });        
                      
                
                $('#jstree').jstree(); 

                var node_selected;
                
                $('#jstree').on("changed.jstree", function(e, data){
                    console.log(data.selected);
                    node_selected = data.selected;
                });               
                

                $('button').on('click', function(){
                    //$('#jstree').jstree(true).select_node('child_node_1');
                    alert(node_selected);
                    //parent.right_frame.location="helloSpring/id=1";                    
                });
                
                $(function(){
                    var to = false;
                    $('#search_tree').keyup(function(){
                        if(to){
                            clearTimeout(to);
                        }
                        to = setTimeout(function(){
                            var v = $("#search_tree").val();
                            $("#jstree").jstree(true).search(v);
                        }, 250);
                    });
                            
                });                
            });            

        </script>
    
    </body>   
    
</html>
