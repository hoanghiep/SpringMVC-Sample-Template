/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */

var Checkbox = React.createClass({
    
    getInitialState: function() {
        return { 
            checked: this.props.checked
        };
    },
    
    getDefaultProps: function () {
        return {
            checked: false,
            id: " "
        };
    },
    
    componentWillReceiveProps : function(nextProps) {
        var _checked = nextProps.checked;
         this.setState({
            checked : _checked
        });
    },    
    
    onChange: function(event) {
        this.setState({
            checked: !this.state.checked
        });
        this.props.onChange(this, event.target.checked);
    },
    render: function() {
        return (
            <div className = "checkbox-react">    
                <input {...this.props}
                    id = {this.props.id}
                    type="checkbox"
                    className="styled"
                    checked={this.state.checked}
                    onChange={this.onChange}
                />
                <label htmlFor={this.props.id}>
                    {this.props.label}
                </label>
            </div>
        );
    }
});