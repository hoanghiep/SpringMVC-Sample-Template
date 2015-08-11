/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */

/**
 * Phân trang
 */
var Pagination = React.createClass({
    
    getInitialState: function() {
        return {
            totalPage : this.props.totalPage,
            currentPage : this.props.currentPage,
            itemsPerPage : this.props.itemsPerpage
        };
    },
        
    propTypes: {
        
    },
    
    getDefaultProps: function() {
        return {
        };
    },
    
    midPage : function(){
        var arr = [];
        if(this.state.totalPage <= 5){
            for(var i = 2; i <= this.state.totalPage; i++){
                arr.push(i);
            }
        }
        else{
            if(this.state.currentPage <= 2){
                arr = [2,3];
            }
            else if(this.state.currentPage == this.state.totalPage){
                arr = [this.state.currentPage - 2, this.state.currentPage - 1];
            }
            else if(this.state.currentPage == this.state.totalPage){
                arr = [this.state.currentPage - 1, this.state.currentPage];
            }            
            else{
                arr =  [this.state.currentPage - 1, this.state.currentPage, parseInt(this.state.currentPage) + 1];
            }
        }
        // console.log("arr -> ", arr);
        return arr;
    },  
    
    paging : function(event){
        var dataId = event.target.getAttribute('data-id');
        var _currentPage = dataId;
        if(dataId === "prev"){
            _currentPage = this.state.currentPage - 1;
        }
        else if(dataId === "next"){
             _currentPage = parseInt(this.state.currentPage) + 1;
        }
        if(this.props.callback){
            this.props.callback(_currentPage);
        }
    },
    
    componentWillReceiveProps: function(nextProps) {
        console.log("p nextProps", nextProps);
        this.setState( {
            totalPage : nextProps.totalPage,
            currentPage : nextProps.currentPage,
            itemsPerPage : nextProps.itemsPerpage
        });
    },
    
    listFromInt : function(intValue, start){
        var arr = [];
        for(var i = start; i <= (start == 0 ? intValue - 1 : intValue); i++){
            arr.push(i);
        }
        return arr;
    },
    
    render : function() {
        var self = this;

        var cssClassFirst = this.props.cssPage + " " + (1 == this.state.currentPage ? this.props.cssCurrentPage : "");
        var cssClassLast = this.props.cssPage + " " + (this.state.totalPage == this.state.currentPage ? this.props.cssCurrentPage : "");

        var prev = this.state.currentPage != 1 && this.state.totalPage > 5 ?
            <li>
                <a data-id="prev" href="#" onClick={this.paging}>Trang trước</a>
            </li>
            :"";
            
        var next = this.state.currentPage < this.state.totalPage && this.state.totalPage > 5 ?
            <li>
                <a data-id="next" href="#" onClick={this.paging}>Trang sau</a>
            </li>
            :"";
            
        var midPageRender = _.map(this.midPage(), function(d){
            var cssClass = self.props.cssPage + " ";
            cssClass += (d == self.state.currentPage ? self.props.cssCurrentPage : " ");
            return (
                <li >
                    <a className={cssClass} data-id={d} href="#" onClick={self.paging}>{d}</a>
                </li>
            ); 
        });  
        
        var last = this.state.totalPage <= 5 ||  this.state.currentPage == this.state.totalPage - 1? "":
            <li >
                <a className={cssClassLast} data-id={this.state.totalPage} href="#" onClick={this.paging}>{this.state.totalPage}</a>
            </li>
    
        // Nếu có nhỏ hơn 5 trang thì render tất cả 
        var render5 = _.map(self.listFromInt(self.state.totalPage, 1), function(d, index){
            var cssClass = self.props.cssPage + " ";
            cssClass += (d == self.state.currentPage ? self.props.cssCurrentPage : " ");
            return (
                <li >
                    <a className={cssClass} data-id={d} href="#" onClick={self.paging}>{d}</a>
                </li>
            ); 
        });  
        
        if(this.state.totalPage <= 5){
            return (<ul className="paging">{render5}</ul>);
        }
        else{
            return (
                <ul className="paging">
                    {prev}
                    <li >
                        <a className={cssClassFirst} data-id="1" href="#" onClick={this.paging}>1</a>
                    </li>
                    {midPageRender}
                    {last}
                    {next}
                </ul>
            );
        }
    }
});
