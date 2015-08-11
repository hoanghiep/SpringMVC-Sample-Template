/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */

var GrayHr = React.createClass({
    render : function(){
        var styleCtl = {
            'color' : '#e5e5e5',
            'height': '1px',
            'backgroundColor': '#e5e5e5',
            'border': 'none'
        };
        return(
            <hr style={styleCtl}/>
        );
    }
});

var Clear = React.createClass({
    render : function(){
        return(
            <div className="clear"></div>
        );
    }
});

var AppLogo = React.createClass({
    render: function(){
        return(
            <div>
                <div id="app-clock">
                    <Clock />
                </div>
                <div className="left app-logo-right">
                     <a href="#"> VOffice</a>
                     <div className="clear"/>
                     <a href="#"> © 2015 Viettel ICT</a>
                </div>
            </div>
        );
    }
});

var NoRecord = React.createClass({
    getInitialState: function() {
        return {
            total : this.props.total
        };
    },
    
    componentWillReceiveProps: function(nextProps) {
        this.setState({
            total : nextProps.total
        });
    },
    
    propTypes: {
        
    },
    render: function(){
        return(
            <div className="no-record">
                {this.state.total > 0 ? "" : "Hiện chưa có bản ghi"}
            </div>
        );
    }
});

React.render(<AppLogo/> , document.getElementById('app-logo'));

